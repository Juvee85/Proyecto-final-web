window.onload = function() {
    cargarMunicipios();
};

function cargarMunicipios() {
    fetch('municipios')
        .then(response => response.json())
        .then(municipios => {
            const selectCiudad = document.getElementById('ciudad');
            municipios.forEach(municipio => {
                const option = document.createElement('option');
                option.value = municipio.nombre;
                option.textContent = municipio.nombre;
                selectCiudad.appendChild(option);
            });
        })
        .catch(error => console.error('Error al cargar municipios:', error));
}