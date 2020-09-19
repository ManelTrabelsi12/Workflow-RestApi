# Workflow-Rest
- Executer le fichier Database.sql
- Modifier le fichier application.properties selon vos proprites 
- Les URLs sont :
**Request Method - GET/ :

Workflows: http://localhost:8080/workflows

WorkflowByID : http://localhost:8080/workflows\1

WorkflowsByNameORStauts :http://localhost:8080/workflows/filter?name="WF2"&status=5

WorkflowCategories: http://localhost:8080/workflowCategories\

WorkflowCategoriesByID : http://localhost:8080/workflowCategories\3

WorkflowsCategoriesByNameORStauts : http://localhost:8080/workflowCategories\filter?name=WFC2&status=5

****Request Method - Post/ :

Workflows : http://localhost:8080/workflows
 EX: {
      
        "name": "WFTest",
        "description": "Test WorkFlow",
        "status": 2
}
WorkflowCategories : /http://localhost:8080/workflowCategories\

EX : {
    "name": "WFCTest",
    "description": "Test WorkFlow Category",
    "logo": null,
    "createAt": null,
    "updateAt": null,
    "status": 3
}
****Request Method - Put/ :
Workflows : http://localhost:8080/workflows
 EX: {
       
       "id_workflow" : 3 ,
        "name": "WFTest",
        "description": "Test WorkFlow",
        "status": 2
}
WorkflowCategories : /http://localhost:8080/workflowCategories\

EX : {
    "id_category":3,
    "name": "WFCTest",
    "description": "Test WorkFlow Category",
    "logo": null,
    "createAt": null,
    "updateAt": null,
    "status": 3
}
**Request Method - DELETE/ :

Workflows: http://localhost:8080/workflows\3

WorkflowCategories: http://localhost:8080/workflowCategories\2


