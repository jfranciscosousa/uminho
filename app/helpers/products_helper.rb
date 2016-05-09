module ProductsHelper
    def color_score(score)
        data = if score > 75
                   "<div class=\"Score_green\">#{score.round}</div>"
               elsif score > 50
                   "<div class=\"Score_yellow\">#{score.round}</div>"
               else
                   "<div class=\"Score_red\">#{score.round}</div>"
               end
        data.html_safe
    end
end
