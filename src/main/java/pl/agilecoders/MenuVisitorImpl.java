package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 08:30
 */
//Concrete visitor
public class MenuVisitorImpl implements MenuVisitor {
    private int tabSize;

    @Override
    public void visit(MenuLeaf menuLeaf) {
        System.out.println(getTabs(tabSize) + "- " + menuLeaf.getName());
    }

    @Override
    public void visit(MenuComposite menuComposite) {
        if (menuComposite.getName() != null && !"".equals(menuComposite.getName())) {
            System.out.println(getTabs(tabSize) + "+ " + menuComposite.getName());

            if(!menuComposite.getChildren().isEmpty()) {
                tabSize+=4;
            }
        }

        for (MenuComponent next : menuComposite.getChildren()) {
            next.accept(this);
            if(isLastChild(menuComposite, next)) {
                tabSize-=4;
            }
        }
    }

    private String getTabs(int tabCount) {
        StringBuffer outputBuffer = new StringBuffer(tabCount);
        for (int i = 0; i < tabCount; i++) {
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    public boolean isLastChild(MenuComposite composite, MenuComponent next) {
        return composite.getChildren().indexOf(next) == (composite.getChildren().size() - 1);
    }
}
