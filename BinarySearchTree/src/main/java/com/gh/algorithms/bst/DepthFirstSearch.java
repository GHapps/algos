package com.gh.algorithms.bst;

/**
 * Created by Gavin on 28/07/2015.
 */
public class DepthFirstSearch<T> {

    private final Graph<T> currentGraph;



    public void initialiseDFS(Node<T> startNode){

        dfs(startNode);

    }

    public DepthFirstSearch(Graph<T> graph, String startLbl){
        currentGraph = graph;
        this.initialiseDFS(currentGraph.getNodeByLabel(startLbl));
    }

    public void dfs(Node<T> startNode){

        int time = 1;
        startNode.setState(States.DISCOVERED);
        startNode.setEntryTime(time);

        startNode.getNeighbours().entrySet().stream().forEach(x -> {
                            

        });
    }

}
