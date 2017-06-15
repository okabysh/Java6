/*общая сумма ЗП всех Java разработчиков, если они напишут все указанные проекты*/
Select
SUM(developers.salary) AS CostProject
from mtm_customer_project
left join projects
	on mtm_customer_project.project = projects.id
left join mtm_customer_project_developer
	on mtm_customer_project.project = mtm_customer_project_developer.project
left join developers
	on mtm_customer_project_developer.developer = developers.id
inner join mtm_developer_skill
		on mtm_developer_skill.developer = developers.id
        and (mtm_developer_skill.skill = 1 or mtm_developer_skill.skill = 2 or mtm_developer_skill.skill = 3)