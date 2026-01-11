package main;

import java.util.List;

import main.Ejercicio_01_insert.InsertBST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Models.Node;
import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: " + estudiante.nombre());
        System.out.println("✉️  Correo: " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ


        System.out.println("\n--- Creando Árbol (Ejercicio 1) ---");
        InsertBST insertBST = new InsertBST();
        Node root = null;
        
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        
        for (int value : values) {
            root = insertBST.insert(root, value);
        }
        
        System.out.println("Estructura Inicial:");
        printTreeByLevels(root);

        System.out.println("\n--- Calculando Profundidad (Ejercicio 4) ---");
        Depth depthAnalyzer = new Depth();
        int maxDepth = depthAnalyzer.maxDepth(root);
        System.out.println("La profundidad máxima es: " + maxDepth);

        System.out.println("\n--- Invirtiendo Árbol (Ejercicio 2) ---");
        InvertBinaryTree inverter = new InvertBinaryTree();
        root = inverter.invertTree(root);
        
        System.out.println("Estructura Invertida:");
        printTreeByLevels(root);
    }

    private static void printTreeByLevels(Node root) {
        ListLevels levelsAnalyzer = new ListLevels();
        List<List<Node>> levels = levelsAnalyzer.listLevels(root);

        for (int i = 0; i < levels.size(); i++) {
            System.out.print("Nivel " + i + ": ");
            for (Node node : levels.get(i)) {
                System.out.print(node.getValue() + " ");
            }
            System.out.println();
        }
    }
}