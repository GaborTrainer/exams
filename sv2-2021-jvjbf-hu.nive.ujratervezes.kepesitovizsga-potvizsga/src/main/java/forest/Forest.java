package forest;

import java.util.ArrayList;
import java.util.List;

public class Forest {

    private List<Tree> trees;

    public Forest(List<Tree> trees) {
        this.trees = trees;
    }

    public void rain() {
        trees.forEach(Tree::irrigate);
    }

    public void cutTrees(Lumberjack lumberjack) {
        trees.removeIf(lumberjack::canCut);
    }

    public boolean isEmpty() {
        return trees.isEmpty();
    }

    public List<String> getStatus() {
        int whitebarkPine = 0;
        int foxtailPine = 0;
        for (Tree tree : trees) {
            if (tree instanceof WhitebarkPine) {
                whitebarkPine++;
            } else {
                foxtailPine++;
            }
        }
        List<String> result = new ArrayList<>();
        result.add("There is a " + whitebarkPine + " tall WhitebarkPine in the forest.");
        result.add("There is a " + foxtailPine + " tall FoxtailPine in the forest.");
        return result;
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
