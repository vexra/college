#include <iostream>
#include <stack>
#include <queue>

using namespace std;

void printStack(stack<int> myStack)
{
    if (myStack.empty()) {
        cout << "Error: stack kosong";
    }

    else {
        while(!myStack.empty()) {
            cout << "[>]" << myStack.top() << endl;
            myStack.pop();
        }
        cout << endl;
    }
}

void printQueue(queue<int> myQueue)
{
        if (myQueue.empty()) {
        cout << "Error: queue kosong";
    }

    else {
        while(!myQueue.empty()) {
            cout << "[>]" << myQueue.front() << endl;
            myQueue.pop();
        }
        cout << endl;
    }
}

int main1()
{
    stack<int> myStack;

    myStack.push(10);    
    myStack.push(20);
    myStack.push(30);

    printStack(myStack);

    cout << "Top element: " << myStack.top() << endl;

    myStack.pop();
    cout << endl;

    printStack(myStack);

    cout << "Top element after pop: " << myStack.top() << endl;

    cout << "Stack size: " << myStack.size() << endl;

    while(!myStack.empty()) {
        myStack.pop();
    }

    printStack(myStack);
    return 0;
}

int main2()
{
    queue<int> myQueue;

    myQueue.push(10);
    myQueue.push(20);
    myQueue.push(30);

    printQueue(myQueue);

    cout << "Front element: " << myQueue.front() << endl;

    myQueue.pop();
    cout << endl;

    printQueue(myQueue);

    cout << "Front element after pop: " << myQueue.front() << endl;

    cout << "Queue size: " << myQueue.size() << endl;

    while(!myQueue.empty()) {
        myQueue.pop();
    }

    printQueue(myQueue);
    return 0;
}

int main()
{
    main1();
    main2();
}