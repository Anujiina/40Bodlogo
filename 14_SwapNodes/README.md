БОДЛОГЫН ХОБООС: https://www.hackerrank.com/challenges/swap-nodes-algo/problem?isFullScreen=true

БОДЛОГЫН ӨГҮҮЛБЭР: Танд дараах өгөгдлүүд өгөгдөнө:
indexes: n хэмжээтэй 2 хэмжээст массив бөгөөд i дахь мөр нь i дугаар узелийн зүүн болон баруун хүүхдүүдийн индексийг агуулна. -1 нь тухайн хүүхэд байхгүйг илэрхийлнэ.
queries: t хэмжээтэй массив бөгөөд тус бүр нь k утгатай. Энэ нь модны түвшин бүрийн солилцоог гүйцэтгэх давтамжийг заана. Тодруулбал, 
түвшин нь k-ийн олонлогт багтсан бол тухайн түвшний бүх узелийн хүүхдүүдийг солих хэрэгтэй. Модыг in-order дарааллаар хэвлэж, үр дүнг хадгалах.
Өгөгдсөн k утгатай query бүрийн дараа модны түвшний солилцоог гүйцэтгэж, шинэ in-order дарааллыг хэвлэх.
Оролт:
3
2 3
-1 -1
-1 -1
2
1
1
Гаралт: 3 1 2 
        2 1 3
Тайлбар:
Эхний query (k=1): Модны бүх түвшний хүүхдүүдийг солих шаардлагатай. Үр дүнд нь модны бүтэц өөрчлөгдөж, in-order дараалал нь 3 1 2 болно.
Хоёр дахь query (k=1): Модны бүх түвшний хүүхдүүдийг дахин солих шаардлагатай. Үр дүнд нь модны бүтэц дахин өөрчлөгдөж, in-order дараалал нь 2 1 3 болно.
Модыг барих: indexes массивыг ашиглан модыг барина. Үүний тулд түвшний дарааллаар (BFS) модыг бүтээж, узел бүрийн зүүн болон баруун хүүхдүүдийг холбох хэрэгтэй.
Түвшний солилцоо хийх: Тухайн түвшний бүх узелийн хүүхдүүдийг солихын тулд түвшний тоог тодорхойлж, k-ийн олонлогт багтсан түвшнүүдийн хүүхдүүдийг солих хэрэгтэй.
in-order дамжуулалт хийх: Модыг in-order дарааллаар дамжуулан, узел бүрийг хэвлэх хэрэгтэй. Энэ нь зүүн хүүхэд, үндсэн, баруун хүүхэд гэсэн дарааллаар гүйцэтгэгдэнэ.


БАТАЛГАА: 

 ![image](https://github.com/user-attachments/assets/aaa92b48-7a60-4a42-9211-1e372e703b4d)
