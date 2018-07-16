import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Tree<T>  {

    Node<T> root;

    public void add(T parent, T child) {
        if (parent == null) {
            if (root == null) {
                root = new Node<T>(child);
                System.out.println("Good! New node was created");
            } else {
                System.out.println("Root already existe");
            }
        } else {
            if (root == null) {
                System.out.println("Root doesn't existe");
            } else {
                if (root.getInformation().equals(parent)) {
                    root.addChild(new Node<T>(child));
                    System.out.println("Good! New node was created");
                } else {
                    Node<T> findedParent = findParent(parent, root.getChilds());
                    if (findedParent != null) {
                        findedParent.addChild(new Node<T>(child));
                        System.out.println("Good! New node was created");
                    } else {
                        System.out.println("Parent didn't created");
                    }
                }
            }
        }

    }

    public Node<T> findParent(T parent, List<Node<T>> childs) {
        for (int i = 0; i < childs.size() ; i++) {
            if (childs.get(i).equals(parent)) {
                return childs.get(i);
            }
            if (childs.get(i).getChilds().size() != 0) {
                return findParent(parent, childs.get(i).getChilds());
            }
        }
        return null;
    }

    public void bypassWidth() {
        Deque<Node<T>> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (nodeQueue.peek() != null) {
            Node<T> node = nodeQueue.pop();
            System.out.println(node);
            if (node.hasChild()) {
                for (int i = 0; i < node.getChilds().size(); i++) {
                    nodeQueue.add(node.getChilds().get(i));
                }
            }
        }
    }

    public void circumvention(Node<T> parent) {
        System.out.println(parent);
        List<Node<T>> nodeList = parent.getChilds();
        if (nodeList.size() != 0) {
            for (int i = 0; i < nodeList.size(); i++) {
                circumvention(nodeList.get(i));
            }
        }
    }
}
