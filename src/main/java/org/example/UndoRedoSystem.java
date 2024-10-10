package org.example;

public class UndoRedoSystem<T> {
        private class Node {
            private T state;
            private Node prevState;
            private Node nextState;

            private Node (T state) {
                this.state = state;
            }

        }
        private Node currentState;
        //Method for undo
        public T undo(){
            if (currentState == null){
                System.out.println("Nothing to undo");
                return null;
            }
            //Get the previous state

            Node previousState = currentState.prevState;
            if (previousState ==null){
                System.out.println("Theres nothing left to undo");
                return null;
            } else {
                //update the current state to the previous state
                currentState = previousState;
            }
            return currentState.state;
        }

        public T redo(){
            if (currentState == null){
                System.out.println("Nothing to redo");
                return null;
            }
            Node nextState = currentState.nextState;
            if (nextState ==null){
                System.out.println("Theres nothing left to redo");
            } else {
                currentState = nextState;
            }
            return currentState.state;

        }

        //perform an operation
        public void  addState (T newState) {
            //create a new node for the new task
            Node newNode = new Node(newState);

            //Set the links for the new Node
            newNode.prevState = currentState;
            newNode.nextState = null;

            //Update the next link for the current state
            if (currentState !=null){
                currentState.nextState = newNode;
            }
            //update the current to the new state
            currentState = newNode;
        }

        //Redo Operation

        public static void main(String[] args) {
            UndoRedoSystem<String> undoRedoSystem = new UndoRedoSystem<>();
            undoRedoSystem.addState("H");
            undoRedoSystem.addState("He");
            undoRedoSystem.addState("Hel");
            undoRedoSystem.addState("Hell");
            undoRedoSystem.addState("Hello");
            undoRedoSystem.addState("Hello ");
            undoRedoSystem.addState("Hello W");
            undoRedoSystem.addState("Hello Wo");
            undoRedoSystem.addState("Hello Wor");
            undoRedoSystem.addState("Hello Worl");
            undoRedoSystem.addState("Hello World");

            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.undo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.undo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.undo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.undo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);

            //Redos
            undoRedoSystem.redo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.redo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.redo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.redo();
            System.out.println("Current State: " + undoRedoSystem.currentState.state);
            undoRedoSystem.redo();



        }

}
