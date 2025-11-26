#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
   // State values:
    enum State {
        UNVISITED = 0,
        VISITING = 1,   // In current path / Unsafe
        SAFE = 2,
        UNSAFE = 3
    };
    vector<State> state;

    bool is_safe_node(int curr_node, vector<vector<int>>& graph) {
        if (state[curr_node] == SAFE) {
            return true;
        } else if (state[curr_node] == UNSAFE) {
            return false;
        }

        // cycle detected
        if (state[curr_node] == VISITING) {
            state[curr_node] = UNSAFE;
            return false;
        }

        // explore current node
        state[curr_node] = VISITING;

        vector<int>& neighbors = graph.at(curr_node);
        for (int neighbor : neighbors) {
            if (!is_safe_node(neighbor, graph)) {
                state[curr_node] = UNSAFE;
                return false;
            }
        }

        state[curr_node] = SAFE;
        return true;
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V = graph.size();
        state.assign(V, UNVISITED);

        for (int n = 0; n < graph.size(); n++) {
            is_safe_node(n, graph);
        }

        vector<int> sorted_safe_nodes;
        for (int idx=0; idx<state.size(); idx++) {
            if (state.at(idx) == SAFE)
                sorted_safe_nodes.push_back(idx);
        }
        
        return sorted_safe_nodes;
    }
};

int main() {
    vector<vector<int>> graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    // vector<vector<int>> graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};

    Solution s;
    vector<int> safe_nodes = s.eventualSafeNodes(graph);

    cout << "Print safe nodes \n";
    for (int s : safe_nodes) {
        cout << s << " ";
    }
    return 0;
}