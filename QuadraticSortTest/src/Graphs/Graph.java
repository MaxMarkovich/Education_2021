package Graph;
import DLinkedList.DLinkedList;

public class Graph {
    DLinkedList<DLinkedList<Integer>> graph;
    int nodes;
    int size = 0;

    public Graph(int node_amount) {
        nodes = node_amount;
        graph = new DLinkedList<DLinkedList<Integer>>();

        for (int i = 0; i < nodes; i++) {
            // initialization

            graph.append(new DLinkedList<Integer>());
        }
    }

    public void add(int initial, int desired) {
        graph.getValueByIndex(initial).append(desired);
        graph.getValueByIndex(desired).append(initial);
        size++;
    }

    public DLinkedList<Integer> get(int index) {
        return graph.getValueByIndex(index);
    }

    public void delete(int initial, int desired)
    {
        for (int i = 0; i < graph.getValueByIndex(desired).size; i++)
        {
            if (graph.getValueByIndex(desired).getValueByIndex(i).equals(initial))
            {
                graph.getValueByIndex(desired).removeNode(i);
                break;
            }
        }
        for (int i = 0; i < graph.getValueByIndex(initial).size; i++)
        {
            if (graph.getValueByIndex(initial).getValueByIndex(i) == desired)
            {
                graph.getValueByIndex(initial).removeNode(i);
                break;
            }
        }

        size--;
    }

    public int get_size() {
        return size;
    }
}