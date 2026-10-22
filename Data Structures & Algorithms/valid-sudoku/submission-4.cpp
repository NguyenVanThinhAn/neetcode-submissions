#include <vector>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9] = {0};
        int cols[9] = {0};
        int boxes[9] = {0};

        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] == '.') continue;

                int val = board[r][c] - '1'; // Map '1'-'9' thành 0-8
                int bit = 1 << val;
                int box_idx = (r / 3) * 3 + (c / 3);

                // Kiểm tra xem bit đã được bật ở bất kỳ đâu chưa
                if ((rows[r] & bit) || (cols[c] & bit) || (boxes[box_idx] & bit)) {
                    return false;
                }

                // Đánh dấu bit đã xuất hiện
                rows[r] |= bit;
                cols[c] |= bit;
                boxes[box_idx] |= bit;
            }
        }

        return true;
    }
};
