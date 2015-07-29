package com.gh.algorithms.bst;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Gavin on 26/07/2015.
 */
public class BredthFirstSearch<T> {
    //Given an assembled graph of nodes, and a startign point, build a Binary search tree
    private static final Logger logger = LogManager.getLogger(BredthFirstSearch.class);

    private Graph<T> currentGraph;
    private Queue<Node<T>> bfsQeueue;

    public BredthFirstSearch(Graph<T> graph, String startlbl){
        currentGraph = graph;
        initiliseBFS(startlbl);
    }

    private void initiliseBFS(String startLbl){
        bfsQeueue = new LinkedList<>();
        //currentGraph.getAllNodes().stream().forEach(x -> bfsQeueue.add(x));
        bfsQeueue.add(currentGraph.getNodeByLabel(startLbl));
    }


    public void bfs(){

        //Node<T> startNode = currentGraph.getNodeByLabel(startPointLbl);
        while(!bfsQeueue.isEmpty()){
            Node<T> treeNode = bfsQeueue.remove();
            treeNode.setState(States.PROCESSED);
            processVertxEarly(treeNode);

            if(treeNode.getNeighbours() != null && !treeNode.getNeighbours().isEmpty()){
                treeNode.getNeighbours().entrySet().stream().forEach( x -> {
                    if(!x.getKey().getState().equals(States.PROCESSED)){
                        processEdge(treeNode, x.getKey(), x.getValue());
                    }

                    if(x.getKey().getState().equals(States.UNDISCOVERED)){
                        x.getKey().setState(States.DISCOVERED);
                        x.getKey().setParent(treeNode);
                        bfsQeueue.add(x.getKey());
                    }
                } );
            }
            processVertxLate(treeNode);
        }
        //startNode.getNeighbours().entrySet().stream().forEach( x -> x.set);
    }

    public void dfs(Node<T> startNode){

        int time = 1;
        startNode.setState(States.DISCOVERED);
        startNode.setEntryTime(time);

        startNode.getNeighbours().entrySet().stream().forEach(x -> {
            if(x.getKey().getState().equals(States.DISCOVERED) ){
                x.getKey().setParent(x.getKey());
                processEdge(startNode, x.getKey(), 1);
                dfs(x.getKey());
            }
            else if(!x.getKey().equals(States.PROCESSED) || currentGraph.isDirected()){
                processEdge(startNode, x.getKey(), 1);
            }

        });
        processVertxLate(startNode);
        time++;
        startNode.setExitTime(time);
        startNode.setState(States.PROCESSED);
    }

    public void findShortestPath(Node<T> start, Node<T> end){
        if (start == end || end == null )
        {
            logger.info("{}", start.getLabel());
        }
        else
        {
            findShortestPath(start, end.getParent());
            logger.info("{}", end.getLabel());
        }

    }

    private void processEdge(Node<T> nx, Node<T> ny, Integer cost){
        logger.info("Processing edge  {} to {} and weight {}", nx.getLabel(), ny.getLabel(), cost);
    }

    private void processVertxEarly(Node<T> x){
        logger.info("Processing vertx early {}", x.getLabel());

    }

    private void processVertxLate(Node<T> y){
        logger.info("Processing vertx late {}", y.getLabel());

    }



}
