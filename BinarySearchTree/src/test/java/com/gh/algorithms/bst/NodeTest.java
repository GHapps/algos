package com.gh.algorithms.bst;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.stream.Stream;

public class NodeTest {
    private Node<Integer> intNode;

    @Before
    public void setUp() throws Exception {

        intNode = new Node<Integer>(1, "1");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void canSetNeighbours(){
        Node<Integer> anotherNode = new Node<Integer>(2, "2");
        intNode.setNeighbour(anotherNode,1);

        //Stream<Node> x = intNode.getNeighbours().stream()

        assertEquals( (Integer) 2, intNode.getNeighbours().entrySet().stream().findFirst().get().getKey().getNodeValue() );

    }
}