$(document).ready(function () {
    // Carregar todas as faturas
    function loadInvoices() {
        $.ajax({
            url: '/api/invoices',
            type: 'GET',
            success: function (data) {
                const tbody = $('#invoiceTable tbody');
                tbody.empty(); // Limpa a tabela antes de recarregar
                data.forEach(invoice => {
                    tbody.append(`
                        <tr>
                            <td>${invoice.id}</td>
                            <td>${invoice.description}</td>
                            <td>${invoice.amount.toFixed(2)}</td>
                            <td>${invoice.dueDate}</td>
                            <td>${invoice.paid ? 'Sim' : 'Não'}</td>
                            <td>
                                <button class="edit" data-id="${invoice.id}">Editar</button>
                                <button class="delete" data-id="${invoice.id}">Excluir</button>
                            </td>
                        </tr>
                    `);
                });
            },
            error: function (err) {
                alert('Erro ao carregar faturas');
            }
        });
    }

    // Carregar faturas ao clicar no botão
    $('#loadInvoices').click(loadInvoices);

    // Criar/Atualizar fatura
    $('#invoiceForm').submit(function (event) {
        event.preventDefault();

        const id = $('#invoiceId').val();
        const invoice = {
            description: $('#description').val(),
            amount: parseFloat($('#amount').val()),
            dueDate: $('#dueDate').val(),
            paid: $('#paid').is(':checked')
        };

        if (id) {
            // Atualizar fatura
            $.ajax({
                url: `/api/invoices/${id}`,
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(invoice),
                success: function () {
                    alert('Fatura atualizada com sucesso');
                    $('#invoiceForm')[0].reset();
                    loadInvoices();
                },
                error: function () {
                    alert('Erro ao atualizar a fatura');
                }
            });
        } else {
            // Criar nova fatura
            $.ajax({
                url: '/api/invoices',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(invoice),
                success: function () {
                    alert('Fatura criada com sucesso');
                    $('#invoiceForm')[0].reset();
                    loadInvoices();
                },
                error: function () {
                    alert('Erro ao criar a fatura');
                }
            });
        }
    });

    // Editar fatura
    $(document).on('click', '.edit', function () {
        const id = $(this).data('id');
        $.ajax({
            url: `/api/invoices/${id}`,
            type: 'GET',
            success: function (invoice) {
                $('#invoiceId').val(invoice.id);
                $('#description').val(invoice.description);
                $('#amount').val(invoice.amount);
                $('#dueDate').val(invoice.dueDate);
                $('#paid').prop('checked', invoice.paid);
            },
            error: function () {
                alert('Erro ao buscar detalhes da fatura');
            }
        });
    });

    // Excluir fatura
    $(document).on('click', '.delete', function () {
        const id = $(this).data('id');
        if (confirm('Tem certeza que deseja excluir esta fatura?')) {
            $.ajax({
                url: `/api/invoices/${id}`,
                type: 'DELETE',
                success: function () {
                    alert('Fatura excluída com sucesso');
                    loadInvoices();
                },
                error: function () {
                    alert('Erro ao excluir a fatura');
                }
            });
        }
    });
});
