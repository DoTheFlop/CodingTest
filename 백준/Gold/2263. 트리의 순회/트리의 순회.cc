#include <iostream>
#include <vector>

using namespace std;

int inorder[100001];
int postorder[100001];
int pos[100001];
int n;

void binaryTree(int in_start, int in_end, int post_start, int post_end) {
    if (in_start > in_end || post_start > post_end) {
        return;
    }

    int root = postorder[post_end];

    printf("%d ", root);

    int p = pos[root];
    int left = p - in_start;

    binaryTree(in_start, p - 1, post_start, post_start + left - 1);
    binaryTree(p + 1, in_end, post_start + left, post_end - 1);
}
int main()
{
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &inorder[i]);
    }
    for (int i = 0; i < n; i++) {
        scanf("%d", &postorder[i]);
    }
    for (int i = 0; i < n; i++) {
        pos[inorder[i]] = i;
    }
    binaryTree(0, n - 1, 0, n - 1);
    return 0;
}