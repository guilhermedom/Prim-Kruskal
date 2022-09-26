# Clustering with Prim-Kruskal
Java implementation of a graph-based clustering algorithm. A graph is created using the input data. Then, Prim/Kruskal algorithms are used to find and colorize clusters.

## Visualizing clusters

Given the input example in file "data.txt", seven clusters can be found. By running this algorithm, we get a class for each point in the dataset. The image below is a plot of the points with colors following the classes (clusters) returned by the algorithm. Each cluster has a unique color. 

The points were grouped under these clusters by creating a structure similar to a minimum spanning tree (MST). The algorithm tries to connect every point in a graph. Groups with less edges in the graph are divided into separate clusters. In the figure, it can be seen that the algorithm considers distinct groups of points having a thin connection as a single cluster. This can be a desired behavior or not, depending on what the user sees as distinct clusters.

![prim-kruskal_clustering](https://user-images.githubusercontent.com/33037020/175795486-30f2800c-8168-478f-a49a-c9a67a6b86eb.png)

## Single-linkage clustering approach

By clustering with Prim/Kruskal, the end result is a clustering algorithm by single-linkage. Such results were already analyzed and improved in the literature. Usually, single-linkage algorithms are combined with other clustering approaches to achieve more accurate results: Gionis, A., Mannila, H., & Tsaparas, P. (2007). Clustering aggregation. Acm transactions on knowledge discovery from data (tkdd), 1(1), 4-es.
