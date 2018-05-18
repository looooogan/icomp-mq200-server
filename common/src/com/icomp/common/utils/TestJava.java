package com.icomp.common.utils;

/**
 * @author TYY
 * @className TestJava
 * @date 2016/6/8 16:55
 */
public class TestJava {
    public static void main(String args[]) throws Exception {
        String str1 = "(A+B)*C+B/X";

    str1 =   str1.replace("B", "10");


       System.out.println(str1);
     //  System.out.println(validateExpression(str1));
   //     Application app = new Application();
     //   Object rval = app.eval("System.out.println(\"555\");return 5;");
//        System.out.println(app.eval(str1));
    }

    public static boolean validateExpression(String expression) {
        //        // 去掉算式中所有的合法项替换为"?"字符
        //        expression = expression.replaceAll("((K|Z|C)\\d\\$(\\d)+(\\.(\\d)*){0,1})", "?");
        //        // 去掉替换后算式中所有的空格
        //        expression = expression.replaceAll(" ", "");
        //        // 如果有两个相邻的项中间没有操作符，则算式不合法
        //        if (expression.matches("^??$")) {
        //            return false;
        //        }
        //        /**
        //         * 增加你需要的函数运算符，如果函数内部参数结构不同则需要改写正则表达式
        //         */
        //        // 如果包含合法max运算符，则替换max运算符为"?"字符
        //        System.out.println("max: " + expression);
        //        if (expression.matches("^(.)*max\\(\\?-\\?,\\d\\)(.)*$")) {
        //            expression = expression.replaceAll("max\\(\\?-\\?,\\d\\)", "?");
        //        }
        //        System.out.println("max: " + expression);
        //        /**
        //         * 增加你需要的程序块运行符，如果程序块内部参数结构不同则需要改写正则表达式
        //         */
        //        // FIXME if-else语句块未实现，等待实现
        //        // 如果包含合法if-else语句块，则替换if-else语句块为"?"字符
        //        // if(expression.matches("^(.)*if\\{(.)*\\}(.)*$")) {
        //        // expression = expression.replaceAll("max\\(\\?-\\?,\\d\\)", "?");
        //        // }
        //        // 必须是倒数第二步：判断小括号左右括弧是否等同，括弧位置是否合法,如果括弧全部合法，则去掉所有括弧
        int num = 0;
        char[] expChars = expression.toCharArray();
        for (int i = 0; i < expChars.length; i++) {
            char temp = expChars[i];
            if (temp == '(') {
                num++;
            } else if (temp == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        if (num > 0) {
            return false;
        }
        expression = expression.replaceAll("\\(|\\)", "");
       // System.out.println(expression);
        // 必须是最后一步：判断仅剩的+-*/四则运算算式是否合法
        expression = expression.replace("-", "+");
        if (expression.matches("^[A-Z]+([\\\\+\\\\-\\\\*\\\\/][A-Z]+)+$")) {
            return true;
        } else {
            return false;
        }

    }

















    static class Application {


        }
    }

