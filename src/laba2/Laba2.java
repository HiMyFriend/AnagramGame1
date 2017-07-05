/*
Напишите класс Matrix, реализующий квадратные матрицы. В нем должны быть определены

конструктор 	с целочисленным параметром --- размером матрицы, создающий единичную матрицу;	
методы Matrix sum(Matrix) и Matrix product(Matrix), вычисляющие сумму и произведение матриц	
матрицы setElement(int row, int column, int value) и getElement(int row, int column), для 	обращения к 	элементам матрицы;
метод 	toString()

Во всех методах предполагается, что передаваемые параметры всегда корректны.
Напишите программу, выводящую первые 10 степеней матрицы 	
[1 1]
[1 0]
 */
package laba2;

class Matrix{
    public int[][] Matr;

    public Matrix(int ar){
        Matr = new int [ar][ar];
        for(int i = 0; i < Matr.length; i++){
            for(int c = 0; c < Matr.length; c++){
                if (i == c){setElement(i, c, 1); continue;}
                getElement(i,c);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int[] Matr1 : Matr) {
            for (int j = 0; j < Matr.length; j++) {
                str.append(Matr1[j]).append(" "); 
            }
            str.append("\n"); 
        }
        return str.toString(); 
    }
    public Matrix sum(Matrix option){
        Matrix result = new Matrix(Matr.length);
        for(int i = 0; i < option.Matr.length; i++){
            for(int c = 0; c < Matr.length; c++){
               result.setElement(i, c, option.getElement(i, c) + getElement(i, c));
            }
        }
        return result;
    }
    public Matrix product(Matrix a){ 
        if(this.Matr.length == a.Matr.length){ 
            Matrix result = new Matrix(Matr.length);
            for(int i = 0; i < Matr.length ; i++){ 
                for(int j = 0; j < Matr.length ; j++){ 
                    int tmp = 0; 
                    for (int k = 0; k < Matr.length; k++){ 
                        tmp += getElement(k,j) * a.getElement(i,k); 
                       } 
                    result.setElement(i,j,tmp); 
                } 
            } 
        return result; 
        } 
        else{ 
            System.out.println("Ошибка! Разный размер матриц"); 
        } 
        return this; 
    }
   
    public Matrix doSortColumn(){
        Matrix result = new Matrix(Matr.length);
        int stol_result = 0;
        int  max = 0;
        int []stolbci = new int [Matr.length];
        for(int i = 0; i < stolbci.length; i++)
           stolbci[i] = -1;
        int counter_stolbci = 0;
        for (int[] Matr1 : Matr) { 
            for(int stol = 0; stol < Matr[0].length; stol++){
                boolean flag = true;
                for(int i = 0; i < stolbci.length; i++)
                    if (stolbci[i] == stol)
                        flag = false;
                if (flag == false) continue;
                int tmp = 0;
                for (int[] Matr2 : Matr)
                    tmp += Matr2[stol];
                if (tmp > max && stolbci[stol] != stol){  
                    max = tmp;
                    stolbci[counter_stolbci] = stol;
                }
            }
            max = 0;
            for(int stol = 0; stol < Matr.length; stol++)
                result.Matr[stol][stol_result] = Matr[stol][stolbci[counter_stolbci]];
            counter_stolbci++;
            stol_result++;
            System.out.print(result);
        }
        return result;
    }
    
    public final int getElement( int row, int column){
        return Matr[row][column];
    }
    public final int setElement(int row, int column, int value){
        return Matr[row][column] = value;
    }    
}

public class Laba2 {
    public static void main(String[] args) {
        Matrix obj = new Matrix(5);
        Matrix qw = new Matrix (5);
        qw.setElement(0, 1, 10);
        qw.setElement(2, 0, 7);
        qw.setElement(2, 4, 8);
        System.out.println(qw);
        obj = qw.doSortColumn();
        /*obj.setElement(0, 1, 1);
        obj.setElement(1, 0, 1);
        obj.setElement(1, 1, 0);
        for(int i = 0; i < 10; i++){
            System.out.println("Степень " + (i+1));
            qw = qw.product(obj);
            System.out.print(qw);
        }*/
    }
}
