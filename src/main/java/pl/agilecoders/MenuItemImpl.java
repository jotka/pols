package pl.agilecoders;

import java.util.ArrayList;
import java.util.List;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:53
 */
public class MenuItemImpl implements MenuItem {
    private List<MenuItem> children = new ArrayList<MenuItem>();

    private String name;

    public MenuItemImpl(String name) {
        this.name = name;
    }

    @Override
    public List<MenuItem> getChildren() {
        return children;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public void add(MenuItem menuItem) {
        children.add(menuItem);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (hasChildren() ? "+ " : "- ") + name;
    }

    @Override
    /**
     * visitor interface impl
     */
    public void accept(MenuItemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLastChild(MenuItem next) {
        return children.indexOf(next) == (children.size() - 1);
    }

    @Override
    public MenuItem getChildByName(String name) {
        for (MenuItem menuItem : children) {
            if (menuItem.getName().equals(name)) return menuItem;
        }
        return null;
    }

}

