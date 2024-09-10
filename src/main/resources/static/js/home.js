$(document).ready(function () {
    
    function loadDataHomeScreen() {
        $.ajax({
            url: 'http://localhost:8080/users/',
            type: 'GET',
            success: function (data) {
                data.forEach(user => {
                    $("#saldo").text(user.saldo);
                    $("#receitas").text(user.totalReceitas);
                    $("#despesas").text(user.TotalDespesas);
                    $("")
                });
            },
            error: function (err) {
                alert('Erro ao carregar faturas');
            }
        });
    }

    // navbar
    $("#home").click(function(){
        window.location.href = '/'
    })
    // page transactions
    $("#transactions").click(function(){
        window.location.href = '/transactions'
    })
    // page planning
    $("#planning").click(function(){
        window.location.href = '/planning'
    })
    // page more
    $("#more").click(function(){
        window.location.href = '/more'
    })
    
    // show and hidde amount
    let isSaldoVisible = true;
    $("#toggle-eye").click(function () {
        let saldo = 1234.56;

        if (isSaldoVisible) {
            $("#saldo").text("R$ ***.**");
            $("#eye-icon").text("👁️‍🗨️");  
        } else {
            $("#saldo").text("R$ "+saldo);
            $("#eye-icon").text("👁️"); 
        }
        isSaldoVisible = !isSaldoVisible;
    });

    // Adicionar uma nova conta
    $('.default-button').click(function () {
        alert('Adicionar uma nova conta aqui!');
        // Aqui você pode implementar a lógica para abrir um modal ou adicionar um formulário
    });

    // Adicionar um novo cartão de crédito
    $('.adicionar').click(function () {
        alert('Adicionar um novo cartão aqui!');
        // Aqui você pode implementar a lógica para abrir um modal ou adicionar um formulário
    });

    // Alternar entre faturas abertas e fechadas
    $('#cartoes .default-button').click(function () {
        $(this).addClass('selected').siblings().removeClass('selected');
        alert('Alterar entre faturas abertas e fechadas');
        // Aqui você pode implementar a lógica para mostrar/ocultar faturas
    });
});
