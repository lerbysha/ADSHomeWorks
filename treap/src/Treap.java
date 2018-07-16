import java.util.concurrent.ThreadLocalRandom;

public class Treap {

    public int x;
    public int y;

    public Treap Left;
    public Treap Right;
    private Treap(int x, int y){
        this.x = x;
        this.y = ThreadLocalRandom.current().nextInt(100);
        this.Left = null;
        this.Right = null;
    }

    private Treap(int x, int y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.Left = left;
        this.Right = right;
    }

    public static Treap Merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;

        if (L.y > R.y) {
            Treap newR = Merge(L.Right, R);
            return new Treap(L.x, L.y, L.Left, newR);
        } else {
            Treap newL = Merge(L, R.Left);
            return new Treap(R.x, R.y, newL, R.Right);
        }
    }

    public void Split(int x, Treap L, Treap R) {
        Treap newTree = null;
        if (this.x <= x) {
            if (Right == null)
                R = null;
            else
                Right.Split(x, newTree, R);
            L = new Treap(this.x, y, Left, newTree);
        } else {
            if (Left == null)
                L = null;
            else
                Left.Split(x, L, newTree);
            R = new Treap(this.x, y, newTree, Right);
        }
    }
    public Treap Add(int x)
    {
        Treap l=null,r=null;
        Split(x, l, r);
        Treap m = new Treap(x, ThreadLocalRandom.current().nextInt(100));
        return Merge(Merge(l, m), r);
    }
    public Treap Remove(int x)
    {
        Treap l=null, m=null, r=null;
        Split(x - 1, l,  r);
        r.Split(x, m,  r);
        return Merge(l, r);
    }
}
