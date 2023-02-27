function eliminar(id) {
    swal({
        title: "¿Estás seguro?",
        text: "Una vez eliminado, no podrás recuperar el proyecto",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                $ajax({
                    url: '/eliminarProyecto/' + id,
                    success: function (res) {
                        console.log(res);
                    }
                });
                swal("Poof! El proyecto ha sido eliminado!", {
                    icon: "success",
                }).then((value) => {
                    if (value) {
                        window.location.href = "/listar";
                    }
                });
            } else {
                swal("El proyecto no ha sido eliminado");
            }
        });
}