$.ajax({
    url: 'http://localhost:8080/saldo',
    type: 'GET',
    success: function(data) {
        // Atualiza o saldo no frontend com o valor vindo do backend
        saldoReal = data.saldo;  // Atualiza a variável saldoReal com o valor do backend
        if (isSaldoVisible) {
            $("#saldo").text(formatarSaldo(saldoReal));
        }
    },
    error: function(error) {
        console.error("Erro ao buscar o saldo:", error);
    }
});
