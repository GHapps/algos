package com.gh.algorithms.bst;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 26/07/2015.
 */
public class Graph<T> {
    //Graph to represent a graph of weighted nodes
    //Contains the edges

    private static final Logger logger = LogManager.getLogger(Graph.class);

    private final List<Node<T>> nodeList = new ArrayList<Node<T>>();

    public void addNode(Node<T> node){
        nodeList.add(node);
    }

    public void addUndirectedEdge(String fromLbl, String toLbl, Integer cost){

        Node<T> from = nodeList.stream().filter(x -> x.getLabel().equals(fromLbl)).findFirst().get();
        Node<T> to = nodeList.stream().filter(x -> x.getLabel().equals(toLbl)).findFirst().get();
        from.setNeighbour(to,cost);
        to.setNeighbour(from, cost);
    }

    public void addDirectedEdge(Node from, Node to, Integer cost){
        from.setNeighbour(to, cost);
    }

    public Node<T> getNodeByLabel(String label){
        return nodeList.stream().filter( x -> x.getLabel().equals(label)).findFirst().get();
    }

    public List<Node<T>> getAllNodes(){
        return nodeList;
    }

    public void printGraphNodes(){
        nodeList.stream().forEach( x -> logger.info("Currently contains node: {}", x.getLabel()));
    }





}
