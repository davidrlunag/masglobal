/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

async function getEmpleados() {
    let url = 'http://localhost:8080/api/empleados';
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function getEmpleadoById(id) {
    let url = 'http://localhost:8080/api/empleados/' +  id;
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}
async function renderUsers() {
    let id = document.getElementById("idEmpleado").value;
    let html = '';
    if (id == ""){
        document.getElementById("tablaEmpleados").style.display="block";
        let users = await getEmpleados();
        users = users.data.body;
        users.forEach(user => {
            let htmlSegment = `<tr>
                                    <td class="th-lg">${user.id}</td>
                                    <td class="th-lg">${user.name}</td>
                                    <td class="th-lg">${user.rol.roleName}</td>
                                    <td class="th-lg">${user.contractTypeName}</td>
                                    <td class="th-lg">${user.annualSalary}</td>
                                </tr>`;
            html += htmlSegment;
        });
    }else{
        let users = await getEmpleadoById(id);
        let user = users.data.body;
        console.log(user);
        if(user != ""){
            html = `<tr>
                                    <td class="th-lg">${user.id}</td>
                                    <td class="th-lg">${user.name}</td>
                                    <td class="th-lg">${user.rol.roleName}</td>
                                    <td class="th-lg">${user.contractTypeName}</td>
                                    <td class="th-lg">${user.annualSalary}</td>
                                </tr>`;
        }else{
            html = `<tr>
                                    <td class="th-lg alert alert-danger" colspan="5">Id del Empleado no Existe</td></tr>`;
        }
    }
    let container = document.getElementById('empleados');
    container.innerHTML = html;
    
}

