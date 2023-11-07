/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Mk Solucoes
 */
public class calcularVerificador {
    public int calcularDigitoVerificador(String codigoBarras) {
     codigoBarras = codigoBarras.trim().toUpperCase();

    // Verifica se o código de barras contém 12 dígitos
    if (codigoBarras.length() != 12) {
        throw new IllegalArgumentException("O código de barras deve ter 12 dígitos.");
    }

    int soma = 0;

    // Percorre o código de barras da direita para a esquerda
    for (int i = codigoBarras.length() - 1; i >= 0; i--) {
        int digito = Character.getNumericValue(codigoBarras.charAt(i));

        // Alterna o fator de multiplicação entre 1 e 3
        int fator = (i % 2 == 0) ? 1 : 3;

        soma += digito * fator;
    }

    int digitoVerificador = 10 - (soma % 10);

    // Se o dígito verificador for 10, o valor deve ser substituído por 0
    if (digitoVerificador == 10) {
        digitoVerificador = 0;
    }

    return digitoVerificador;
}
    
     public int calcularDigitoVerificador8(String codigo) {
       codigo = codigo.trim().toUpperCase();

    // Verifica se o código de barras contém 7 dígitos
    if (codigo.length() != 7) {
        throw new IllegalArgumentException("O código EAN-8 deve ter 7 dígitos.");
    }

    int soma = 0;

    // Percorre o código de barras da direita para a esquerda
    for (int i = codigo.length() - 1; i >= 0; i--) {
        int digito = Character.getNumericValue(codigo.charAt(i));

        // Alterna o fator de multiplicação entre 3 e 1
        int fator = (i % 2 == 0) ? 3 : 1;

        soma += digito * fator;
    }

    int digitoVerificador = 10 - (soma % 10);

    // Se o dígito verificador for 10, o valor deve ser substituído por 0
    if (digitoVerificador == 10) {
        digitoVerificador = 0;
    }

    return digitoVerificador;
}

    
}
