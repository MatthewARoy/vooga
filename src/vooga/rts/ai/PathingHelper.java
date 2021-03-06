package vooga.rts.ai;

import java.util.Queue;
import vooga.rts.map.*;
import vooga.rts.util.Location;

public class PathingHelper {
    
    private Pathfinder myFinder;
    private GameMap myMap;
    private Queue<MapNode> myPath;
    private MapNode myNext;
    
    public PathingHelper () {
        myFinder = new AstarFinder();
    }
    
    public void constructPath (Location start, Location desired) {
        MapNode startNode = myMap.getNode(start);
        MapNode desiredNode = myMap.getNode(desired);
        myPath = myFinder.findPath(startNode, desiredNode, myMap);
        myNext = myPath.poll();
    }
    
    public Location getNext(Location current) {
        MapNode currentNode = myMap.getNode(current);
        if (!currentNode.equals(myNext)) {
            myNext = myPath.poll();
        }
        return myNext.getLocation();
    }
    
    public int size () {
        return myPath.size();
    }
}
