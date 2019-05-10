#include <iostream>
#include <unistd.h>

using namespace std;

class Tree
{
    public:
        class Node
        {
            private:
                int ertek;
                Node *bal;
                Node *jobb;

            public:
                Node(int val) { ertek = val; bal = jobb = NULL; }

                ~Node() { delete bal; delete jobb; }

                Node * balra() { return bal; }

                Node * jobbra() { return jobb; }

                Node * balra(Node *ujBalLevel) { bal = ujBalLevel; }

                Node * jobbra(Node *ujJobbLevel) { jobb = ujJobbLevel; }

                int & tartalma() { return ertek; }
        };

        Node *root;

        Tree(Node *rootElement) { root = rootElement; resetPosition(); }

        ~Tree() { }

        void addElement(int value)
        {
            if (value < 128)
                if (position->balra() == NULL)
                {
                    position->balra(new Node(value));
                    resetPosition();
                }
                else
                    position = position->balra();
            else
                if (position->jobbra() == NULL)
                {
                    position->jobbra(new Node(value));
                    resetPosition();
                }
                else
                    position = position->jobbra();
        }

        void printInorder(Node * elem)
        {
            if (elem != NULL)
            {
                printInorder(elem -> balra());
                cout << elem -> tartalma() << endl;
                printInorder(elem -> jobbra());
            }
        }

    private:
        Node *position;

        void resetPosition() { position = root; }
};

int main()
{
    Tree *fa = new Tree(new Tree::Node('/'));
    unsigned char b;

    while (read(fileno(stdin), (void *) &b, sizeof(b))) fa->addElement(b);

    fa->printInorder(fa->root);

    cout << "done" << endl;
    return 0;
}