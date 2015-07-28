package com.gh.algorithms.bst;

import javax.swing.plaf.nimbus.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gavin on 26/07/2015.
 */
public class Node<T> {

    private final T data;
    private final Map<Node<T>, Integer> neighbours = new HashMap<Node<T>, Integer>();
    private final String label;
    private States state = States.UNDISCOVERED;

//    public Node(){
//
//    }

    public Node(T nodeData, String nodeLabel){
        data = nodeData;
        label = nodeLabel;
    }


    public Map<Node<T>, Integer> getNeighbours(){
        return neighbours;
    }

    public T getNodeValue(){
        return data;
    }

    public void setNeighbour(Node<T> neighbour, Integer cost){
        neighbours.put(neighbour, cost);
    }

    public String getLabel() {
        return label;
    }

    public void setState(States state) {
        this.state = state;
    }

    public States getState() {
        return state;
    }
}
