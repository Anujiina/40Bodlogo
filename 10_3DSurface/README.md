БОДЛОГЫН ХОЛБООС: https://www.hackerrank.com/challenges/3d-surface-area/problem

БОДЛОГЫН ӨГҮҮЛБЭР: Танд 2D хүснэгт өгөгдөх ба энэ нь нэгж шоо (1x1x1 хэмжээтэй шоо)-гоор бүтсэн 3D бүтэцийг илэрхийлнэ.
Хүснэгтийн A[i][j] утга нь тухайн байршил дээр тэгш өрлөгтэйгээр хэр олон шоо босгосон болохыг заана.
Өөрөөр хэлбэл, A[i][j] = 3 гэвэл тухайн байрлалд 3 шоо босоо байрласан байна гэсэн үг.
Энэ 3D хэлбэрийн нийт гадаргуугийн талбайг (surface area) тооцоолно.
Жишээ тайлбар:
Оролт:
1 3 4  
2 2 3  
1 2 4  
Энэ нь дараах 3D бүтэцтэй тэнцүү: Эхний мөр: (1,3,4) Хоёрдугаар мөр: (2,2,3)
Гуравдугаар мөр: (1,2,4) Тус бүрт босоо шоо овоолсон байна.
Талбайг хэрхэн тооцох вэ?
Нэг шоо нь дараах талбайтай: 6 нэгж талбайтай (1x1x6).
Гэхдээ хэрэв хөрш шоо байвал нүүр талууд нь давхардаж, дотоод талбай болж тооцогдохгүй.
Тиймээс:
Дээш ба доош талууд — үргэлж 1x1 = 1 (дээд) + 1 (доод) = 2 талбай
Зүүн, баруун, урд, хойд талууд — хөрш шоо байхгүй бол 1 талбай, байвал зөрүүгээр тооцно.
Жишээ:
Хэрэв нэг байршилд 3 шоо байвал:
Дээд = 1
Доод = 1
Зүүн = хөршөөс хамаарна
Баруун = хөршөөс хамаарна
Урд = хөршөөс хамаарна
Хойд = хөршөөс хамаарна
Хэрэв тухайн талд хөрш байхгүй бол бүрэн илүү талбай болно (1), хөрш байвал хоёр шооны өндөр зөрүүгээр талбай нэмэгдэнэ.


БАТАЛГАА: 

 ![image](https://github.com/user-attachments/assets/15399589-ad6f-49b8-9753-9608a6ee2c83)
