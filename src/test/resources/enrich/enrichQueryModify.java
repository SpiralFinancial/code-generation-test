package net.binis.codegen;

import net.binis.codegen.enrich.handler.ModifierEnricher;
import net.binis.codegen.enrich.handler.QueryEnricher;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.SubPrototype;
import java.util.List;

@CodePrototype(enrichers = {QueryEnricher.class, ModifierEnricher.class})
public interface TestPrototype {
    String title();

    double amount();

    List<Long> items();

    TestPrototype parent();

    SubPrototype sub();
}