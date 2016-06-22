# duitang_test
堆糖的笔试
# 接口使用
[120.76.121.17:8080/duitang_test/answer/?I=1,7,3,4](120.76.121.17:8080/duitang_test/answer/?I=1,7,3,4) (点击测试接口)  
或更换测试数据，接口地址：`120.76.121.17:8080/duitang_test/answer/?`  
由于题目没有明确要求，该接口仅对输入参数值为空进行校验提醒，对于参数具体格式限制没有做校验。  
# 实现
- 应题目要求和问题规模，该接口实现采用原生`Servlet`开发，轻量高效。
- 核心算法正好和我之前写的一篇[博客](http://blog.csdn.net/xiaotan24/article/details/50786796)很相似，时间复杂度为`O(n)`。
- 具体代码见`com.duitang.controller.AnswerServlet`类
