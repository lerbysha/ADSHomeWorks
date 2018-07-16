import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T information;

    private List<Node<T>> childs = new ArrayList<>();

    public Node(T information) {
        this.information = information;
    }

    public void addChild(Node childNew){
        childs.add(childNew);
    }


    public List<Node<T>> getChilds() {
        return childs;
    }

    public T getInformation() {
        return information;
    }

    public boolean hasChild() {
        if (childs.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        if (information != null ? !information.equals(node.information) : node.information != null) return false;
        return childs != null ? childs.equals(node.childs) : node.childs == null;
    }

    @Override
    public int hashCode() {
        int result = information != null ? information.hashCode() : 0;
        result = 31 * result + (childs != null ? childs.hashCode() : 0);
        return result;
    }



}
