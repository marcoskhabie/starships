package edu.austral.starship.base.util;

import edu.austral.starship.base.util.Visitor;

public interface Visitable {
   void accepts(Visitor visitor);
}
