#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string> seen;

        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                char val = board[r][c];
                if (val == '.') continue;

                // Tạo chuỗi định danh độc nhất cho hàng, cột và hộp 3x3
                string rowKey = "r" + to_string(r) + "_" + val;
                string colKey = "c" + to_string(c) + "_" + val;
                string boxKey = "b" + to_string(r / 3) + "_" + to_string(c / 3) + "_" + val;

                // insert().second trả về false nếu chuỗi đã tồn tại trong set
                if (!seen.insert(rowKey).second || 
                    !seen.insert(colKey).second || 
                    !seen.insert(boxKey).second) {
                    return false;
                }
            }
        }
        return true;
    }
};
