#include <vector>
#include <future>
#include <atomic>
#include <chrono>

using namespace std;

class Solution {
public:
    static bool checkRows(const vector<vector<char>>& board, atomic<bool>& cancel) {
        for (int r = 0; r < 9; ++r) {
            if (cancel.load(memory_order_relaxed)) return false;
            int mask = 0;
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '1';
                if ((mask & (1 << val)) != 0) {
                    cancel.store(true, memory_order_relaxed);
                    return false;
                }
                mask |= (1 << val);
            }
        }
        return true;
    }

    static bool checkCols(const vector<vector<char>>& board, atomic<bool>& cancel) {
        for (int c = 0; c < 9; ++c) {
            if (cancel.load(memory_order_relaxed)) return false;
            int mask = 0;
            for (int r = 0; r < 9; ++r) {
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '1';
                if ((mask & (1 << val)) != 0) {
                    cancel.store(true, memory_order_relaxed);
                    return false;
                }
                mask |= (1 << val);
            }
        }
        return true;
    }

    static bool checkBoxes(const vector<vector<char>>& board, atomic<bool>& cancel) {
        for (int box = 0; box < 9; ++box) {
            if (cancel.load(memory_order_relaxed)) return false;
            int mask = 0;
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            for (int r = 0; r < 3; ++r) {
                for (int c = 0; c < 3; ++c) {
                    char ch = board[startRow + r][startCol + c];
                    if (ch == '.') continue;
                    int val = ch - '1';
                    if ((mask & (1 << val)) != 0) {
                        cancel.store(true, memory_order_relaxed);
                        return false;
                    }
                    mask |= (1 << val);
                }
            }
        }
        return true;
    }

    bool isValidSudoku(vector<vector<char>>& board) {
        atomic<bool> cancel(false);

        auto rowTask = async(launch::async, checkRows, cref(board), ref(cancel));
        auto colTask = async(launch::async, checkCols, cref(board), ref(cancel));
        auto boxTask = async(launch::async, checkBoxes, cref(board), ref(cancel));

        bool rowDone = false, colDone = false, boxDone = false;
        const auto zero_wait = chrono::milliseconds(0);

        // Vòng lặp thăm dò phản hồi từ 3 luồng
        while (!rowDone || !colDone || !boxDone) {
            if (!rowDone && rowTask.wait_for(zero_wait) == future_status::ready) {
                if (!rowTask.get()) { cancel.store(true); return false; }
                rowDone = true;
            }
            if (!colDone && colTask.wait_for(zero_wait) == future_status::ready) {
                if (!colTask.get()) { cancel.store(true); return false; }
                colDone = true;
            }
            if (!boxDone && boxTask.wait_for(zero_wait) == future_status::ready) {
                if (!boxTask.get()) { cancel.store(true); return false; }
                boxDone = true;
            }
            this_thread::yield(); // Nhường CPU để các worker thread xử lý tiếp
        }

        return true;
    }
};
