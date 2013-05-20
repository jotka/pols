package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 20.05.13
 * Time: 18:28
 */
public class MenuLeaf implements MenuComponent {
    private String name;

    public MenuLeaf(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visit(this);
    }
}
