token设计：
1) 该token用于后端返回数据加密
2) 在user表之外创建user_info表，用于存储token等
3) 如果需要考虑性能，在redis中存储token