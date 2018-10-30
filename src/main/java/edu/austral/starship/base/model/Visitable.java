package edu.austral.starship.base.model;

import edu.austral.starship.base.util.Visitor;

public interface Visitable {
   void accepts(Visitor visitor);
}
