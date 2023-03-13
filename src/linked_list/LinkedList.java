package linked_list;


public class LinkedList<T> {

    private Node<T> head;

    public void add(T data) {
        Node<T> n = new Node<>(data);
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public T get(int index) {
        int i = 0;
        Node<T> temp = head;
        while (temp != null) {
            if (i == index) return temp.data;
            temp = temp.next;
            i = i + 1;
        }
        return null;
    }

    public void removeAt(int index) {
        if (index > 0) {
            Node<T> temp = head;
            if (index == 0) {
                if (temp.next == null) head = null;
                else {
                    head = temp.next;
                }
            } else {
                int count = 0;
                while (temp != null) {
                    if (temp.next == null) throw new MyException("Dizi Boyutu indexten küçük!");
                    if (count == index - 1) {
                        Node<T> n = temp;
                        Node<T> next = n.next.next;
                        n.next = next;
                        break;
                    }
                    count++;
                    temp = temp.next;
                }
            }
        } else throw new MyException("Index negatif olamaz!");
    }

    public void remove(T data) {
        if (head == null) {
            throw new MyException("Liste boş");
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        throw new MyException("Eleman bulunamadı");
    }


    public int size() {
        int count = 0;
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("NULL");
        } else {
            while (temp != null) {
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    public void showList() {
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("Liste Boş");
        } else {
            System.out.print("[ ");
            while (temp != null) {
                System.out.print(temp.data + " , ");
                temp = temp.next;
            }
            System.out.println("]");
        }
    }

    public void addFirst(T data) {
        Node<T> n = new Node<>(data);
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            n.next = head;
            head = n;
        }
    }

    public void add1(int index, T data) {
        Node<T> n = new Node<>(data);
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            Node<T> temp = head;
            int count = 0;
            while (temp != null && count < index - 1) {
                temp = temp.next;
                count++;
            }
            if (temp == null) {
                System.out.println("Geçersiz indeks");
            } else {
                n.next = temp.next;
                temp.next = n;
            }
        }
    }

    public void clear() {
        head = null;
    }

    public static <T> boolean contains(LinkedList<T> list, T data) {
        if (data == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            if (element.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public T getFirst() {
        if (head == null) {
            throw new MyException("Dizi boş!");
        }
        return head.data;
    }


    public T getLast() {
        if (head == null)
            throw new MyException("Dizi boş!");

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void toArray() {
        int count = 0;
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("Dizi boş");
        } else {
            while (temp != null) {
                count++;
                temp = temp.next;
            }
        }
        T[] array = (T[]) new Object[count]; // Generic array creation
        int i = 0;
        temp = head;
        while (temp != null) {
            array[i] = temp.data;
            temp = temp.next;
            i++;
        }
        for (T element : array) {
            System.out.print(element + " ");
        }
    }
    public T[] toArray1() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        T[] array = (T[]) new Object[count];
        int i = 0;
        temp = head;
        while (temp != null) {
            array[i++] = temp.data;
            temp = temp.next;
        }
        return array;
    }
    public void set(int index, T data) {
        int count = 0;
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("LinkedList boş.");
        } else {
            while (temp != null) {
                count++;
                temp = temp.next;
            }
        }
        if (index < 0 || index >= count) {
            throw new MyException("Hatalı girdi");
        }

        temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.data = data;
    }
}