package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 08:26
 */
//Visitor interface
public interface MenuVisitor {
    void visit(MenuLeaf menuLeaf);
    void visit(MenuComposite menuComposite);
}
