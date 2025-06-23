package java.kdnn;

import java.inout.Customer;

import java.util.List;

public class KDTree {
    KDN root;

    public KDTree(List<Customer> customers) {
        root = build(customers, true);
    }

    private KDN build(List<Customer> customers, boolean isVertical) {
        if (customers.isEmpty()) return null;

        customers.sort((a, b) -> isVertical ?
                Double.compare(a.x, b.x) : Double.compare(a.y, b.y));

        int mid = customers.size() / 2;
        KDN node = new KDN(customers.get(mid), isVertical);
        node.left = build(customers.subList(0, mid), !isVertical);
        node.right = build(customers.subList(mid + 1, customers.size()), !isVertical);
        return node;
    }

    public Customer nearestNeighbor(Customer target) {
        KDN best = nearest(root, target, root, Double.MAX_VALUE);
        return best != null ? best.customer : null;
    }

    private KDN nearest(KDN node, Customer target, KDN best, double bestDist) {
        if (node == null) return best;

        double d = distance(node.customer, target);
        if (d < bestDist && !node.customer.equals(target)) {
            bestDist = d;
            best = node;
        }

        boolean compareByX = node.isVertical;
        double cmp = compareByX ? target.x - node.customer.x : target.y - node.customer.y;

        KDN first = (cmp < 0) ? node.left : node.right;
        KDN second = (cmp < 0) ? node.right : node.left;

        best = nearest(first, target, best, bestDist);

        double axisDist = compareByX ? Math.abs(target.x - node.customer.x) : Math.abs(target.y - node.customer.y);
        if (axisDist < bestDist) {
            best = nearest(second, target, best, bestDist);
        }

        return best;
    }


    private double distance(Customer a, Customer b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

}