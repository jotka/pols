package pl.agilecoders;

import java.util.ArrayList;
import java.util.List;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 20.05.13
 * Time: 18:19
 */

//composite impl
public class MenuComposite implements MenuComponent {

    private List<MenuComponent> children = new ArrayList<MenuComponent>();

    private String name;

    public MenuComposite(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<MenuComponent> getChildren() {
        return children;
    }

    public void add(MenuComponent menuComponent) {
        children.add(menuComponent);
    }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visit(this);
    }

}
