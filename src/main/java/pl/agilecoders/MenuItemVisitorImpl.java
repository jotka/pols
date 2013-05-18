package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 08:30
 */
public class MenuItemVisitorImpl implements MenuItemVisitor {
    private int tabSize;

    @Override
    public void visit(MenuItem menuItem) {

        if (menuItem.getName() != null && !"".equals(menuItem.getName())) {
            System.out.println(getTabs(tabSize) + menuItem);
        }

        if(menuItem.hasChildren()) {
            tabSize+=4;
        }

        for (MenuItem next : menuItem.getChildren()) {
            visit(next);

            if (menuItem.isLastChild(next)) {
                tabSize -= 4;
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
}
