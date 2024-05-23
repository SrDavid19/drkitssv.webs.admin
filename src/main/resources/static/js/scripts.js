function loadClientData(button) {
    const clientId = button.getAttribute('data-id');
    fetch(`/clientes/${clientId}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('edit-id').value = data.id;
            document.getElementById('edit-nombres').value = data.nombres;
            document.getElementById('edit-apellidos').value = data.apellidos;
            document.getElementById('edit-contacto').value = data.contacto;
        })
        .catch(error => console.error('Error:', error));
}
