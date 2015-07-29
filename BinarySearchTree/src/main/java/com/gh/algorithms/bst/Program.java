package com.gh.algorithms.bst;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Gavin on 26/07/2015.
 */
public class Program {

    private static final Logger log = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        //Create a graph for the website!
        Graph<String> graph = new Graph<String>();

        Node<String> indexNode = new Node<>("index.html", "index.html");
        graph.addNode(indexNode);

        Node<String> privacyNode = new Node<>("privacy.html", "privacy.html");
        graph.addNode(privacyNode);

        Node<String> contactNode = new Node<>("contact.html", "contact.html");
        graph.addNode(contactNode);

        Node<String> aboutNode = new Node<>("about.html", "about.html");
        graph.addNode(aboutNode);



        Node<String> personalInfoNode = new Node<>("personalInfo.html", "personalInfo.html");
        graph.addNode(personalInfoNode);

        Node<String> accountSettings = new Node<>("accountSettings.html","accountSettings.html");
        graph.addNode(accountSettings);




        graph.addUndirectedEdge("index.html", "about.html", 3);
        graph.addUndirectedEdge("index.html", "personalInfo.html", 2);
        graph.addUndirectedEdge("index.html", "accountSettings.html", 3);
        graph.addUndirectedEdge("about.html", "contact.html", 1);
        graph.addUndirectedEdge("about.html", "privacy.html", 1);

        graph.addUndirectedEdge("personalInfo.html", "accountSettings.html", 1);

        graph.printGraphNodes();

        BredthFirstSearch<String> bfs = new BredthFirstSearch<String>(graph, "privacy.html");

        bfs.bfs();
        log.info("Finding the shortest path throught he graph from start!");
        bfs.findShortestPath(indexNode, contactNode);
        log.info("Finding depth first search!");
        bfs.dfs(indexNode);

    }


}
