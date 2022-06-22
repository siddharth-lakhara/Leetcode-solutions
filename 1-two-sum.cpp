#include <iostream>
#include <vector>
#include <set>
#include <map>

using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> answer(2, 0);
    set<int> requiredNums;
    map<int, int> reverseMapping;
    for (auto it = nums.begin(); it != nums.end(); it++) {
      int value = *it;
      int idx = it - nums.begin();
      if (requiredNums.find(value) != requiredNums.end()) {
        // element found
        int otherValue = target - value;
        answer[0] = reverseMapping[otherValue];
        answer[1] = idx;
        break;
      } else {
        // element not found
        int diff = target - value;
        requiredNums.insert(diff);
        reverseMapping[value] = idx;
      }
    }
    return answer;
  }
};

int main() {
  vector<int> nums = {3, 2, 4};
  int target = 6;
  Solution S;
  vector<int> answer = S.twoSum(nums, target);
  for (auto it : answer) {
      cout << it << endl;
  }
  return 0;
}
