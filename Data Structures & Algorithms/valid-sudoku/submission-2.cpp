#include <vector>
#include <future>

using namespace std;

class Solution {
public:
    // 1. Kiểm tra 9 hàng
    static bool checkRows(const vector<vector<char>>& board) {
        for (int r = 0; r < 9; ++r) {
            int mask = 0;
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '1';
                if ((mask & (1 << val)) != 0) return false;
                mask |= (1 << val);
            }
        }
        return true;
    }

    // 2. Kiểm tra 9 cột
    static bool checkCols(const vector<vector<char>>& board) {
        for (int c = 0; c < 9; ++c) {
            int mask = 0;
            for (int r = 0; r < 9; ++r) {
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '1';
                if ((mask & (1 << val)) != 0) return false;
                mask |= (1 << val);
            }
        }
        return true;
    }

    // 3. Kiểm tra 9 hộp 3x3
    static bool checkBoxes(const vector<vector<char>>& board) {
        for (int box = 0; box < 9; ++box) {
            int mask = 0;
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            for (int r = 0; r < 3; ++r) {
                for (int c = 0; c < 3; ++c) {
                    char ch = board[startRow + r][startCol + c];
                    if (ch == '.') continue;
                    int val = ch - '1';
                    if ((mask & (1 << val)) != 0) return false;
                    mask |= (1 << val);
                }
            }
        }
        return true;
    }

    bool isValidSudoku(vector<vector<char>>& board) {
        // Khởi chạy 3 tác vụ chạy ngầm song song
        auto rowTask = async(launch::async, checkRows, cref(board));
        auto colTask = async(launch::async, checkCols, cref(board));
        auto boxTask = async(launch::async, checkBoxes, cref(board));

        // Lấy kết quả từ cả 3 luồng
        return rowTask.get() && colTask.get() && boxTask.get();
    }
};
