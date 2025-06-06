БОДЛОГЫН ХОЛБООС: https://www.hackerrank.com/challenges/the-time-in-words/problem?isFullScreen=true

БОДЛОГЫН ӨГҮҮЛБЭР: Тоон хэлбэрээр өгөгдсөн цагийг үгээр илэрхийлэх боломжтой, дараах жишээнүүдийн дагуу:

5:00 → five o’ clock
5:01 → one minute past five
5:10 → ten minutes past five
5:15 → quarter past five
5:30 → half past five
5:40 → twenty minutes to six
5:45 → quarter to six
5:47 → thirteen minutes to six
5:28 → twenty eight minutes past five
Цагийн минут нь 00 байвал o' clock гэж хэрэглэнэ. Хэрэв минут нь 1-ээс 30 хүртэл байвал past, харин 31-ээс 59 хүртэл байвал to гэж хэрэглэнэ.
o' clock гэж бичихдээ ' апострофын дараа нэг зай тавигдах ёстой. Цагийг үгээр илэрхийлдэг програм бич. 
Функцийн тайлбар
timeInWords функцийг дараах хэлбэрээр гүйцээнэ:
Параметрүүд:
int h: өдрийн цагийн утга (1–12)
int m: тухайн цаг өнгөрсөн минут
Буцаах утга:
string: үгээр илэрхийлсэн цагийн мөр
Оролтын формат
Эхний мөрөнд h (цаг)
Хоёр дахь мөрөнд m (минут)


НОТОЛГОО:  ![image](https://github.com/user-attachments/assets/0fe7a1d8-e388-408b-b4f0-2930dcfb45db)




