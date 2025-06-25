import java.util.*;

public class KDTree {
    private final KDN root;

    public KDTree(List<Customer> customers) {
        root = build(customers, true);
    }

    private KDN build(List<Customer> customers, boolean isVertical) {
        if (customers.isEmpty()) return null;

        customers.sort((a, b) -> isVertical ?
                Double.compare(a.getX(), b.getX()) : Double.compare(a.getY(), b.getY()));

        int mid = customers.size() / 2;
        KDN node = new KDN(customers.get(mid), isVertical);
        node.left = build(customers.subList(0, mid), !isVertical);
        node.right = build(customers.subList(mid + 1, customers.size()), !isVertical);
        return node;
    }

    public Customer nearestNeighbor(Customer target, Set<Customer> unvisited) {
        KDN bestNode = nearest(root, target, null, Double.MAX_VALUE, unvisited);
        return bestNode != null ? bestNode.getCustomer() : null;
    }

    private KDN nearest(KDN node, Customer target, KDN best, double bestDist, Set<Customer> unvisited) {
        if (node == null) {
            return best;
        }

        if (unvisited.contains(node.getCustomer())) {
            double currdist = distance(node.getCustomer(), target);
            if (currdist < bestDist && !node.getCustomer().equals(target)) {
                bestDist = currdist;
                best = node;
            }
        }

        boolean comX = node.getIsVertical();
        double coo1 = comX ? target.getX() : target.getY();
        double coo2 = comX ? node.getCustomer().getX() : node.getCustomer().getY();

        KDN C1 = (coo1 < coo2) ? node.left : node.right;
        KDN C2 = (coo1 < coo2) ? node.right : node.left;

        KDN newC1 = nearest(C1, target, best, bestDist, unvisited);
        if (newC1 != null && unvisited.contains(newC1.getCustomer())) {
            double distFromFirst = distance(newC1.getCustomer(), target);
            if (distFromFirst < bestDist) {
                bestDist = distFromFirst;
                best = newC1;
            }
        }

        double axisDist = Math.abs(coo1 - coo2);
        if (axisDist * axisDist < bestDist) {
            KDN newC2 = nearest(C2, target, best, bestDist, unvisited);
            if (newC2 != null && unvisited.contains(newC2.getCustomer())) {
                double distC2 = distance(newC2.getCustomer(), target);
                if (distC2 < bestDist) {
                    bestDist = distC2;
                    best = newC2;
                }
            }
        }

        return best;
    }


    private double distance(Customer a, Customer b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

}