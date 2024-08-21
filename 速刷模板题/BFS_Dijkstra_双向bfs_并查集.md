# 一般宽度优先算法
## BFS
~~~go
~~~
## Dijkstra
~~~go
~~~
## 双向BFS(在大图中有更高的效率)

## 合并并查集
[合并并查集](https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/)
~~~go
func shortestDistanceAfterQueries(n int, queries [][]int) (res []int) {
	// road[i] means form i to road[i]+1
	// for example: road[2] = 2 means 2 -> 3 road[0] = 3 means 0 to 4
	road := make([]int, n-1)
	for i := range road {
		road[i] = i
	}
	find := func(x int) (key int) {
		key = x
		//寻找x的祖先节点
		for road[key] != key {
			key = road[key]
		}
		//路径压缩
		for road[x] != key {
			road[x], x = key, road[x]
		}
		return
	}
	//合并并查集的过程
	count := n - 1
	for _, querie := range queries {
		start, end := querie[0], querie[1]-1
		endRoot := find(end)
        // i = find(i+1) 是寻找出下个集合并合并
		for i := find(start); i < end; i = find(i+1) {
			road[i] = endRoot
			count--
		}
		res = append(res, count)
	}
	return
}
~~~